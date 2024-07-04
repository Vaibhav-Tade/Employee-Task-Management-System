package com.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.dao.ProjectDao;
import com.taskmanagement.entity.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	public Project addProject(Project project) {
		return projectDao.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectDao.save(project);
	}
	
	public List<Project> getAllProjects() {
		return projectDao.findAll();
	}
	
	public Project getProjectById(int projectId) {
		
		Project p = null;
		
		Optional<Project> oP = projectDao.findById(projectId);
		
		if(oP.isPresent()) {
			p = oP.get();
		}
		
		return p;
	}
	
	public List<Project> getAllProjectsByProjectName(String projectName) {
		return projectDao.findByNameContainingIgnoreCase(projectName);
	}
	
	public List<Project> getAllProjectsByProjectNameAndManagerId(String projectName, int managerId) {
		return projectDao.findByNameContainingIgnoreCaseAndManagerId(projectName, managerId);
	}
	
	public List<Project> getAllProjectsByProjectNameAndEmployeeId(String projectName, int employeeId) {
		return projectDao.findByNameContainingIgnoreCaseAndEmployeeId(projectName, employeeId);
	}
	
	public List<Project> getAllProjectsByEmployeeId(int employeeId) {
		return projectDao.findByEmployeeId(employeeId);
	}
	
	public List<Project> getAllProjectsByManagerId(int managerId) {
		return projectDao.findByManagerId(managerId);
	}

}

//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.taskmanagement.dao.ProjectDao;
//import com.taskmanagement.entity.Project;
//
//@Service
//public class ProjectService {
//    
//    @Autowired
//    private ProjectDao projectDao;
//    
//    public Project addProject(Project project) {
//        return projectDao.save(project);
//    }
//    
//    public Project updateProject(Project project) {
//        return projectDao.save(project);
//    }
//    
//    public Page<Project> getAllProjects(Pageable pageable) {
//        return projectDao.findAll(pageable);
//    }
//    
//    public Project getProjectById(int projectId) {
//        return projectDao.findById(projectId).orElse(null);
//    }
//    
//    public Page<Project> getAllProjectsByProjectName(String projectName, Pageable pageable) {
//        return projectDao.findByNameContainingIgnoreCase(projectName, pageable);
//    }
//    
//    public Page<Project> getAllProjectsByProjectNameAndManagerId(String projectName, int managerId, Pageable pageable) {
//        return projectDao.findByNameContainingIgnoreCaseAndManagerId(projectName, managerId, pageable);
//    }
//    
//    public Page<Project> getAllProjectsByProjectNameAndEmployeeId(String projectName, int employeeId, Pageable pageable) {
//        return projectDao.findByNameContainingIgnoreCaseAndEmployeeId(projectName, employeeId, pageable);
//    }
//    
//    public Page<Project> getAllProjectsByEmployeeId(int employeeId, Pageable pageable) {
//        return projectDao.findByEmployeeId(employeeId, pageable);
//    }
//    
//    public Page<Project> getAllProjectsByManagerId(int managerId, Pageable pageable) {
//        return projectDao.findByManagerId(managerId, pageable);
//    }
//}
