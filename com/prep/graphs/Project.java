package com.prep.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project {
	
	enum State {
		VISITED,
		VISITING,
		NONE
	}
	
	private String name;
	
	private List<Project> dependentProjects;
	
	private int dependencies;
	
	private State state;
	
	public Project(String name) {
		this.name = name;
		dependentProjects = new ArrayList<>();
		this.state = State.NONE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getdependentProjects() {
		return dependentProjects;
	}

	public void setdependentProjects(List<Project> dependencies) {
		this.dependentProjects = dependentProjects;
	}

	public int getNumDependencies() {
		return dependencies;
	}

	public void setNumDependencies(int dependentProjects) {
		this.dependencies = dependencies;
	}
	
	public void addDependentProject(Project project) {
		dependentProjects.add(project);
	}
	
	public void removcedependentProjects(Project project) {
		dependentProjects.remove(project);
	}
	
	public void addDependency() {
		dependencies++;
	}
	
	public void removeDependency() {
		dependencies--;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
