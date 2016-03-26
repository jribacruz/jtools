package jtools.commons.model.base;

import java.io.File;

import jtools.commons.types.XCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * Classe que representa um diretório.
 * 
 * @author jcruz
 *
 */
public interface XDir {

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente.
	 * 
	 * @return
	 */
	public XCollection<XFile> getAllFiles();

	/**
	 * 
	 * Retorna todos os arquivos do diretório corrente e dos subdiretórios.
	 * 
	 * @return
	 */
	public XCollection<XFile> getAllFiles(boolean recursively);

	/**
	 * Retorna o diretório pai
	 * 
	 * @return
	 */
	public XDir getParent();

	/**
	 * 
	 * Retorna os diretórios filhos.
	 * 
	 * @return
	 */
	public XCollection<XDir> getChildDirs();

	/**
	 * 
	 * Retorna os diretórios filhos recursivamente (incluindo subdiretórios).
	 * 
	 * @return
	 */
	public XCollection<XDir> getChildDirs(boolean recursively);

	/**
	 * 
	 * Retorna um diretório filho (incluindo os subdiretórios) especificado.
	 * 
	 * @param dir
	 * @return
	 */
	public XDir getChild(String dir);

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
	public <F extends IOFileFilter> XCollection<XFile> filter(F filter);

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
	public <F extends IOFileFilter> XCollection<XFile> filter(F filter, boolean recursively);

}
