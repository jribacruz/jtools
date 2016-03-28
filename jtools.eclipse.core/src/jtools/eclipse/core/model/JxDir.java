package jtools.eclipse.core.model;

import java.io.File;

import jtools.eclipse.core.JxCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * Classe que representa um diretório.
 * 
 * @author jcruz
 *
 */
public interface JxDir {

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente.
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getAllFiles();

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente e dos subdiretórios.
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getAllFiles(boolean recursively);

	/**
	 * Retorna o diretório pai
	 * 
	 * @return
	 */
	public JxDir getParent();

	/**
	 * 
	 * Retorna os diretórios filhos.
	 * 
	 * @return
	 */
	public JxCollection<JxDir> getChildDirs();

	/**
	 * 
	 * Retorna os diretórios filhos recursivamente (incluindo subdiretórios).
	 * 
	 * @return
	 */
	public JxCollection<JxDir> getChildDirs(boolean recursively);

	/**
	 * 
	 * Retorna um diretório filho (incluindo os subdiretórios) especificado.
	 * 
	 * @param dir
	 * @return
	 */
	public JxDir getChild(String dir);

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
	public <F extends IOFileFilter> JxCollection<JxFile> filter(F filter);

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
	public <F extends IOFileFilter> JxCollection<JxFile> filter(F filter, boolean recursively);

}
