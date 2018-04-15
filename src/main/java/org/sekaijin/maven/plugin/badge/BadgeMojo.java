/*
 * Copyright 20100 Conor Roche
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sekaijin.maven.plugin.badge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.util.StringUtils;
import org.sekaijin.maven.plugin.badge.font.FontProvider;
import org.sekaijin.maven.plugin.badge.font.FontProviderLocator;
import org.sekaijin.maven.plugin.badge.svg.SVGImageColor;
import org.sekaijin.maven.plugin.badge.svg.SVGImageData;
import org.sekaijin.maven.plugin.badge.svg.SVGImageGenerator;
import org.sekaijin.maven.plugin.badge.svg.SVGImageTemplate;

/**
 * Goal which merges text files from a series of directories into a single text output file
 * @goal  resources
 * @phase process-resources
 * @requiresProject
 */
public class BadgeMojo extends AbstractMojo {

	/**
	 * @parameter
	 * @required
	 */
	private Badge[] badges;
	/**
	 * default: ${project.basedir}/target/site/resources/
	 * @parameter expression="${project.basedir}/target/site/resources/"
	 * @required
	 */
	protected File outputDir;
	private SVGImageGenerator ig;
	private FontProvider fp;

	public BadgeMojo() throws IOException {
		super();
		FontProviderLocator fpl = new FontProviderLocator();
		ig = new SVGImageGenerator(fpl);
		getLog().info("SVGImageGenerator is now ready.");
		fp = fpl.fontProvider();
	}

	/**
	 * @see org.apache.maven.plugin.AbstractMojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		getOutputDir().mkdirs();
		for (Badge badge : this.badges) {
			try{
				String svg = makeBadge(badge);

				String path = getOutputDir().getAbsolutePath()+"/"+badge.getName().toLowerCase()+".svg";
				FileUtils.writeStringToFile(new File(path), svg, CharEncoding.UTF_8);
				getLog().debug(path+" ok");

			}catch(Exception e){
				getLog().warn(e.getMessage());
			}

			getLog().info("Finished : " + badge.getName() + " " + badge.getVersion() + " " + getOutputDir() + " ");

		}
	}

	public String makeBadge(Badge badge){

		SVGImageData data;
		if (StringUtils.isEmpty(badge.getVersion())) {
			data = SVGImageData.Builder.instance(fp)
					.withLabelBackgroundColor(SVGImageColor.DARK_GREY)
					.withLabelText(badge.getName())
					.withTemplate(SVGImageTemplate.SIMPLE)
					.build();
		} else {
			data = SVGImageData.Builder.instance(fp)
					.withLabelBackgroundColor(SVGImageColor.DARK_GREY)
					.withLabelText(badge.getName())
					.withValueBackgroundColor(badge.getColor())
					.withValueText(badge.getVersion())
					.withTemplate(SVGImageTemplate.ROUNDED)
					.build();
		}


		return ig.buildFor(data);

	}

	/**
	 * @return the badges
	 */
	public Badge[] getBadges(){
		return badges;
	}

	/**
	 * @param badges the badges to set
	 */
	public void setBadges(Badge[] badges){
		this.badges = badges;
	}

	/**
	 * @return the outputDir
	 */
	public File getOutputDir(){
		return outputDir;
	}

	/**
	 * @param outputDir the outputDir to set
	 */
	public void setOutputDir(File outputDir){
		this.outputDir = outputDir;
	}


}
