package com.root.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDAO {
	
	public String upload(String path, MultipartFile proFile) throws Exception {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		
		// 2. 어떤 파일을 무슨 이름으로 저장할 것인가
		//	1) 시간
//		Calendar ca = Calendar.getInstance();
//		long mil = ca.getTimeInMillis();//1234567
//		String type = proFile.getOriginalFilename().substring(proFile.getOriginalFilename().lastIndexOf("."));
//		System.out.println(mil+type);
//		String f = mil+type;
		//	2) UUID 객체 사용
		String f = UUID.randomUUID().toString();
		f = f + "_" +proFile.getOriginalFilename();
		
		// 3. HDD에 저장
		//	1) transferTo
		file = new File(file, f);
//		proFile.transferTo(file);
		//	2) FileCopyUtils
		FileCopyUtils.copy(proFile.getBytes(), file);
		
		return f;
		
	}

}
