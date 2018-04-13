package fr.aphp.ati.eai.olympe.maven.plugin.badge;

import java.util.HashMap;
import java.util.Map;

import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageColor;

public class BadgeColor
{
   static Map<String, SVGImageColor> map = new HashMap<String, SVGImageColor>();
   static {
      for (SVGImageColor color : SVGImageColor.values()) {
         map.put(color.toString().toLowerCase(), color);
       }
   }
   
   public static SVGImageColor getFor(String name) {
      return BadgeColor.map.get(name);
   }
}
