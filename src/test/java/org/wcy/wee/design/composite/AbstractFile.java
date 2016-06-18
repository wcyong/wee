package org.wcy.wee.design.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {

	public void killVirus();
	
}

class ImageFile implements AbstractFile {

	@Override
	public void killVirus() {
		System.out.println("图像文件");
	}
	
}

class TxtFile implements AbstractFile {

	@Override
	public void killVirus() {
		System.out.println("文本文件");
	}
	
}

class VideoFile implements AbstractFile {

	@Override
	public void killVirus() {
		System.out.println("视频文件");
	}
	
}

class Floder implements AbstractFile{

	private List<AbstractFile> list = new ArrayList<>();
	
	public void add(AbstractFile file) {
		list.add(file);
	}
	
	public void remove(AbstractFile file) {
		list.remove(file);
	}
	
	@Override
	public void killVirus() {
		System.out.println("文件夹");
		for(AbstractFile file : list) {
			file.killVirus();
		}
	}
	
}