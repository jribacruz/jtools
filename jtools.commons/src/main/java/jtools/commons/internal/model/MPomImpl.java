package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import jtools.commons.internal.model.base.MXmlImpl;
import jtools.commons.model.MPom;
import jtools.commons.model.MPomDependency;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MPomImpl extends MXmlImpl implements MPom {

	public MPomImpl(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		super(xmlFile);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#getGroupId()
	 */
	@Override
	public String getGroupId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#getArtifactId()
	 */
	@Override
	public String getArtifactId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#getVersion()
	 */
	@Override
	public String getVersion() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#getDependencies()
	 */
	@Override
	public TCollection<MPomDependency> getDependencies() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#hasDependency(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean hasDependency(String groupId, String artifactId, String version) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#addDependency(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void addDependency(String groupId, String artifactId, String version) {}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MPom#removeDependency(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void removeDependency(String groupId, String artifactId, String version) {}

}
