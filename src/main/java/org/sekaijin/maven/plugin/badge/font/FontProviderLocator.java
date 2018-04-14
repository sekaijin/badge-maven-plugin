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
package org.sekaijin.maven.plugin.badge.font;

import java.awt.Font;

import org.sekaijin.maven.plugin.badge.exception.FontLoadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that locates a suitable {@link FontProvider}.
 *
 * @author Michel Pawlak
 */
public class FontProviderLocator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FontProviderLocator.class);

    private FontProvider fontProvider;

    /**
     * Constructor that locates the most suitable {@link FontProvider}.
     */
    public FontProviderLocator() {
        try {
            this.fontProvider = new PreferredFontProvider();
        } catch (final FontLoadingException e) {
            LOGGER.debug("Preferred font could not be loaded:", e);
            this.fontProvider = new FallbackFontProvider();
        }
    }

    /**
     * Returns a {@link FontProvider} giving access to the preferred {@link Font} or fallback {@link Font}.
     *
     * @return the most suitable {@link FontProvider}
     */
    public FontProvider fontProvider() {
        return this.fontProvider;
    }

}
