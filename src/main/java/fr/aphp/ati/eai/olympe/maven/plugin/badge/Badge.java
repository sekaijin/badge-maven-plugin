package fr.aphp.ati.eai.olympe.maven.plugin.badge;

import org.apache.commons.lang.StringUtils;

import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageColor;

public class Badge
{
   /**
    * texte du badge.
    * @parameter
    * @required
    */
   private String name;

   /**
    * version du badge.
    * @parameter
    */
   private String version=StringUtils.EMPTY;

   /**
    * couleur du badge.
    * @parameter
    * @required
    */
   private SVGImageColor color;

   public String getName(){
      return name;
   }

   public String getVersion(){
      return version;
   }

   public SVGImageColor getColor(){
      return color;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name){
      this.name = name;
   }

   /**
    * @param version the version to set
    */
   public void setVersion(String version){
      this.version = version;
   }

   /**
    * @param color the color to set
    */
   public void setColor(SVGImageColor color){
      this.color = color;
   }

}
