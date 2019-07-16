package com.prep.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.prep.graphs.Project.State;

public class ProjectDependencies {

	public static void main(String[] args) {
		String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
		List<Dependency> dependencies = new ArrayList<>();
		Dependency d1 = new Dependency();
		d1.project = "d";
		d1.dependency = "a";
		dependencies.add(d1);
		
		Dependency d2 = new Dependency();
		d2.project = "b";
		d2.dependency = "f";
		dependencies.add(d2);
		
		Dependency d3 = new Dependency();
		d3.project = "d";
		d3.dependency = "b";
		dependencies.add(d3);
		
		Dependency d4 = new Dependency();
		d4.project = "a";
		d4.dependency = "f";
		dependencies.add(d4);
		
		Dependency d5 = new Dependency();
		d5.project = "c";
		d5.dependency = "d";
		dependencies.add(d5);
		
		Graph graph = new Graph();
		graph.buildGraph(projects, dependencies);
		
//		List<Project> buildOrder = getBuildOrder(graph, projects);
//		for (Project project : buildOrder) {
//			System.out.print(project.getName() + "->");
//		}
		System.out.println();
		
		List<Project> buildOrder2 = getBuildOrderDFS(graph, projects);
		for (Project project : buildOrder2) {
			System.out.print(project.getName() + "->");
		}
		System.out.println();
	}
	
	public static List<Project> getBuildOrder(Graph graph, String[] projects) {
		List<Project> buildOrder = new ArrayList<>(projects.length);
		
		// add projects with no dependencies
		addNonDependentProjects(graph, graph.getProjects(), buildOrder);
		if (buildOrder.size() == 0) {
			// circular dependency exists
			return null;
		}
		
		int offset = 0;
		while (offset < projects.length) {
			
			// get built project and remove it from dependencies
			Project project = buildOrder.get(offset);
			
			if (project == null) {
				return null;
			}
			
			for (Project dependent : project.getdependentProjects()) {
				dependent.removeDependency();
			}
			
			offset++;
			addNonDependentProjects(graph, project.getdependentProjects(), buildOrder);
		}
		return buildOrder;
	}
	
	private static void addNonDependentProjects(Graph graph, List<Project> projects, List<Project> buildOrder) {
		for (Project project : projects) {
			if (project.getNumDependencies() == 0) {
				buildOrder.add(project);
			}
		}
	}
	
	public static List<Project> getBuildOrderDFS(Graph graph, String[] projects) {
		List<Project> buildOrder = new ArrayList<>();
		Stack<Project> projectStack = new Stack<>();
		for (Project project : graph.getProjects()) {
			if (project.getNumDependencies() == 0) {
				getBuildOrderDFSHelper(project, projectStack);
			}
		}
		while (!projectStack.isEmpty()) {
			buildOrder.add(projectStack.pop());
		}
		return buildOrder;
	}
	
	private static void getBuildOrderDFSHelper(Project project, Stack<Project> stack) {
		if (project == null) {
			return;
		}
		
		if (project.getdependentProjects().size() == 0) {
			project.setState(State.VISITING);
			stack.push(project);
			return;
		}
		
		for (Project dependent : project.getdependentProjects()) {
			if (dependent.getState() == State.NONE) {
				getBuildOrderDFSHelper(dependent, stack);
			}
		}
		project.setState(State.VISITING);
		stack.push(project);
	}

}
