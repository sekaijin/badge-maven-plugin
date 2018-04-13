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

/**
 * Colors used by the {@link BadgesPlugin}
 *
 * @author Michel Pawlak
 */
public enum SVGImageColor
{

   BRIGHT_GREEN("#49c31b"),
   GREEN("#8fbd07"), 
   YELLOW_GREEN("#9fa025"), 
   YELLOW("#d1aa1d"), 
   ORANGE("#ea7637"), 
   RED("#d05a43"),
   LIGHT_GREY("#969696"), 
   BLUE("#0779b9"), 
   DARK_GREY("#565656");

   private String hexColor;

   /**
    * Constructs a {@link SVGImageColor}.
    *
    * @param hexColor color as a hex string
    */
   SVGImageColor(final String hexColor){
      this.hexColor = hexColor;
   }

   /**
    * {@link SVGImageColor} as hex string
    *
    * @return colors as a hex string
    */
   public String hexColor(){
      return this.hexColor;
   }

}
