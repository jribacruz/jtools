package jtools.commons.model;

import java.io.File;

import jtools.commons.types.TCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * Classe que representa um diretório.
 * 
 * @author jcruz
 *
 */
public interface TMDir {

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente.
	 * 
	 * @return
	 */
	public TCollection<TMFile> getAllFiles();

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente e dos subdiretórios.
	 * 
	 * @return
	 */
	public TCollection<TMFile> getAllFiles(boolean recursively);

	/**
	 * Retorna o diretório pai
	 * 
	 * @return
	 */
	public TMDir getParent();

	/**
	 * 
	 * Retorna os diretórios filhos.
	 * 
	 * @return
	 */
	public TCollection<TMDir> getChildDirs();

	/**
	 * 
	 * Retorna os diretórios filhos recursivamente (incluindo subdiretórios).
	 * 
	 * @return
	 */
	public TCollection<TMDir> getChildDirs(boolean recursively);

	/**
	 * 
	 * Retorna um diretório filho (incluindo os subdiretórios) especificado.
	 * 
	 * @param dir
	 * @return
	 */
	public TMDir getChild(String dir);

	/**
	 * 
	 * Retorna o objeto File que representa o diretório.
	 * 
	 * @return
	 */
	public File getFileDir();

	/**
	 * 
	 * Busca por arquivos no diretório corrente dado um filtro.
	 * 
	 * @param filter
	 * @return
	 */
	public <F extends IOFileFilter> TCollection<TMFile> filter(F filter);

	/**
	 * 
	 * Busca por arquivos recursivamente (incluindo subdiretórios) dado um filtro.
	 * 
	 * @param filter
	 *            Filtro de busca.
	 * @param recursively
	 *            Flag de recursividade
	 * @return Lista de TMFiles filtrados.
	 */
	public <F extends IOFileFilter> TCollection<TMFile> filter(F filter, boolean recursively);

}
