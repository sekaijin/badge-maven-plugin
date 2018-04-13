/*
 * qualinsight-plugins-sonarqube-badges
 * Copyright (c) 2015-2016, QualInsight
 * http://www.qualinsight.com/
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, you can retrieve a copy
 * from <http://www.gnu.org/licenses/>.
 */
package fr.aphp.ati.eai.olympe.maven.plugin.badge.svg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import fr.aphp.ati.eai.olympe.maven.plugin.badge.font.FontProvider;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.font.FontProviderLocator;

/**
 * Generates SVG images.
 *
 * @author Michel Pawlak
 */
public final class SVGImageGenerator {

    private FontProvider fontProvider;

    /**
     * {@link SVGImageGenerator} IoC constructor.
     *
     * @param fontProviderLocator {@link FontProviderLocator} that will give access to a {@link FontProvider}.
     * @throws IOException if a font provider exception occurs
     */
    public SVGImageGenerator(final FontProviderLocator fontProviderLocator) throws IOException {
        this.fontProvider = fontProviderLocator.fontProvider();
    }

    /**
     * Generates a SVG image object from a provided Data object.
     *
     * @param data Data object holding data required to produce a SVGGraphics2D object
     * @return generated String SVG image from
     */


    public String buildFor(final SVGImageData data) {

       final Map<String, String> replacements = new HashMap<String, String>();
       replacements.put("{{fontFamily}}", data.fontFamily());
       replacements.put("{{labelText}}", data.labelText());
       replacements.put("{{labelBackgroundColor}}", data.labelBackgroundColor()
           .hexColor());
       replacements.put("{{labelWidth}}", data.labelWidth());
       replacements.put("{{labelHalfWidth}}", data.labelHalfWidth());
       replacements.put("{{valueText}}", data.valueText());
       replacements.put("{{valueBackgroundColor}}", data.valueBackgroundColor()
           .hexColor());
       replacements.put("{{valueWidth}}", data.valueWidth());
       replacements.put("{{valueHalfWidth}}", data.valueHalfWidth());
       replacements.put("{{totalWidth}}", data.totalWidth());
       return StringUtils.replaceEach(data.template()
           .content(),
           replacements.keySet()
               .toArray(new String[0]),
           replacements.values()
               .toArray(new String[0]));
   }
    
    /**
     * Returns the {@link FontProvider} to be used by badge generators.
     *
     * @return font
     */
    public FontProvider fontProvider() {
        return this.fontProvider;
    }

}
