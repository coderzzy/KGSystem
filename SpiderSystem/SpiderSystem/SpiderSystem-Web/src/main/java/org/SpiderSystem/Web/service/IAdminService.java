package org.SpiderSystem.Web.service;

import org.SpiderSystem.Web.pojo.Admin;

public interface IAdminService {
	public int isSubmit(String adminEmail,String adminPassword);
	
	public Admin getAdminById(int adminId);
	
	public boolean updateAdmin(int id,String email,String name,String telephone,String qq,String twitter,String intro);
}