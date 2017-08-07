package com.wisemoney.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

@Service
public class UserRoleDaoImpl implements UserRoleDao {
	
	
	@Override
	public UserRole getRole(String roleName) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("from UserRole ur where ur.roleName=:roleName");
		query.setString("roleName", roleName);
		UserRole userRole = (UserRole) query.uniqueResult();
		
		tx.commit();
		s.close();
		return userRole;
		
	}

}
