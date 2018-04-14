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
package org.sekaijin.maven.plugin.badge.svg;

import org.sekaijin.maven.plugin.badge.font.FontProvider;

/**
 * Container holding data required in order to generate SVG images.
 *
 * @author Michel Pawlak
 */
public class SVGImageData {

    private String labelText;

    private String valueText;

    private SVGImageColor labelBackgroundColor;

    private SVGImageColor valueBackgroundColor;

    private int labelWidth;

    private int valueWidth;

    private int totalWidth;

    private int labelHalfWidth;

    private int valueHalfWidth;

    private String fontFamily;

    private SVGImageTemplate template;

    private SVGImageData() {
    }

    /**
     * Value text getter.
     *
     * @return value text
     */
    public String valueText() {
        return this.valueText;
    }

    /**
     * Label text getter.
     *
     * @return label text
     */
    public String labelText() {
        return this.labelText;
    }

    /**
     * Value background color getter.
     *
     * @return value background color.
     */
    public SVGImageColor valueBackgroundColor() {
        return this.valueBackgroundColor;
    }

    /**
     * Label background color getter.
     *
     * @return label background color.
     */
    public SVGImageColor labelBackgroundColor() {
        return this.labelBackgroundColor;
    }

    /**
     * Width in pixels of the content part of the badge.
     *
     * @return labelWidth
     */
    public String labelWidth() {
        return String.valueOf(this.labelWidth);
    }

    /**
     * Width in pixels of the value part of the badge.
     *
     * @return valueWidth
     */
    public String valueWidth() {
        return String.valueOf(this.valueWidth);
    }

    /**
     * Total width of the SVGImage from left border to right border.
     *
     * @return image width
     */
    public String totalWidth() {
        return String.valueOf(this.totalWidth);
    }

    /**
     * Size in pixels as a String from left border of the SVG image to the middle of the label part of the badge.
     *
     * @return labelHalfWidth
     */
    public String labelHalfWidth() {
        return String.valueOf(this.labelHalfWidth);
    }

    /**
     * Size in pixels as a String from left border of the SVG image to the middle of the value part of the badge.
     *
     * @return valueHalfWidth
     */
    public String valueHalfWidth() {
        return String.valueOf(this.valueHalfWidth);
    }

    /**
     * Returns the font family to be used to generate a SVG image.
     *
     * @return font-family
     */
    public String fontFamily() {
        return this.fontFamily;
    }

    /**
     * Returns the {@link SVGImageTemplate} to be used to generate a SVG image.
     *
     * @return template
     */
    public SVGImageTemplate template() {
        return this.template;
    }

    /**
     * {@link SVGImageData} builder class.
     *
     * @author Michel Pawlak
     */
    public static class Builder {

        private static final int X_MARGIN = 6;

        private SVGImageData data = new SVGImageData();

        private FontProvider fontProvider;

        private Builder(final FontProvider fontProvider) {
            this.fontProvider = fontProvider;
        }

        /**
         * Sets the {@link SVGImageTemplate} to be used to generate the SVG badge.
         *
         * @param template {@link SVGImageTemplate}
         * @return builder
         */
        public Builder withTemplate(final SVGImageTemplate template) {
            this.data.template = template;
            return this;
        }

        /**
         * Sets the text of the label part of a SVG badge.
         *
         * @param labelText badge's label text
         * @return builder
         */
        public Builder withLabelText(final String labelText) {
            this.data.labelText = labelText;
            return this;
        }

        /**
         * Sets the text of the value part of a SVG badge.
         *
         * @param valueText badge's value text
         * @return builder
         */
        public Builder withValueText(final String valueText) {
            this.data.valueText = valueText;
            return this;
        }

        /**
         * Sets the background color to be used for the label part of the SVG badge.
         *
         * @param labelBackgroundColor background color to be used
         * @return builder
         */
        public Builder withLabelBackgroundColor(final SVGImageColor labelBackgroundColor) {
            this.data.labelBackgroundColor = labelBackgroundColor;
            return this;
        }

        /**
         * Sets the background color to be used for the value part of the SVG badge.
         *
         * @param valueBackgroundColor background color to be used
         * @return builder
         */
        public Builder withValueBackgroundColor(final SVGImageColor valueBackgroundColor) {
            this.data.valueBackgroundColor = valueBackgroundColor;
            return this;
        }

        /**
         * Computes SVGImageData measures then builds the SVGImageData
         *
         * @return a SVGImageData
         */
        public SVGImageData build() {
            final int labelRawWidth = this.fontProvider.computeWidth(this.data.labelText());
            final int valueRawWidth = this.fontProvider.computeWidth(this.data.valueText());
            final int localLabelWidth = labelRawWidth + (2 * X_MARGIN);
            final int localValueWidth = valueRawWidth + (2 * X_MARGIN);
            this.data.labelWidth = localLabelWidth;
            this.data.valueWidth = localValueWidth;
            this.data.totalWidth = localLabelWidth + localValueWidth;
            this.data.labelHalfWidth = localLabelWidth / 2;
            this.data.valueHalfWidth = localLabelWidth + (localValueWidth / 2);
            this.data.fontFamily = this.fontProvider.fontFamilyName();
            return this.data;
        }

        /**
         * Instantiates a new Data container.
         *
         * @param fontProvider to be used in order to compute text width
         * @return empty data container
         */
        public static Builder instance(final FontProvider fontProvider) {
            return new Builder(fontProvider);
        }

    }
}
