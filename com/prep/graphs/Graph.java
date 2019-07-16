package com.prep.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	
	List<Project> projectNodes;
	Map<String, Project> projectNameToProjectMap;
	
	public Graph() {
		projectNodes = new ArrayList<>();
		projectNameToProjectMap = new HashMap<>();
	}
	
	public void buildGraph(String[] projects, List<Dependency> dependencies) {
		for (int i = 0; i < projects.length; i++) {
			Project project = new Project(projects[i]);
			projectNodes.add(project);
			projectNameToProjectMap.put(projects[i], project);
		}
		
		for (Dependency dep : dependencies) {
			Project project = projectNameToProjectMap.get(dep.project);
			Project dependency = projectNameToProjectMap.get(dep.dependency);
			dependency.addDependentProject(project);
			project.addDependency();
		}
	}
	
	public Project getProject(String name) {
		return projectNameToProjectMap.get(name);
	}
	
	public List<Project> getProjects() {
		return projectNodes;
	}

}
