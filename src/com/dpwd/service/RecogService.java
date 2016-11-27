package com.dpwd.service;

import com.dpwd.dao.RecogDao;
import com.dpwd.entity.RContent;
import com.dpwd.exception.ContentNotFoundException;

public class RecogService {

	private RecogDao recogdao = new RecogDao();
	
	public RContent getContentById(RContent rc) throws ContentNotFoundException{
		try {
			System.out.println("����Service");
			RContent  rcontent = recogdao.findById(rc);
			
			if (rcontent == null) {
				throw new ContentNotFoundException("ID����checkout����ȷ");
			}
			
			return rcontent;
		} catch (ContentNotFoundException e) {
			throw e;
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
