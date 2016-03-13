package jtools.commons.model;

import java.io.File;

import jtools.commons.types.TCollection;

public interface TMDir {

	/**
	 * 
	 * @return
	 */
	public TCollection<File> getFiles();

	/**
	 * 
	 * @return
	 */
	public TMDir getParent();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMDir> getChildDirs();

	/**
	 * 
	 * @param dir
	 * @return
	 */
	public TMDir getChild(String dir);
}
