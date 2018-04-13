package fr.aphp.ati.eai.olympe.maven.plugin.badge;

import org.junit.Test;

import fr.aphp.ati.eai.olympe.maven.plugin.badge.font.FontProvider;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.font.FontProviderLocator;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageColor;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageData;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageGenerator;
import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageTemplate;

public class ImageTest
{
   @Test
   public void imgTest() throws Exception {
      FontProviderLocator fpl = new FontProviderLocator();
      SVGImageGenerator ig = new SVGImageGenerator(fpl);
      
      FontProvider fp = fpl.fontProvider();
      SVGImageTemplate template = SVGImageTemplate.ROUNDED;
      SVGImageData data = SVGImageData.Builder.instance(fp)
         .withLabelBackgroundColor(SVGImageColor.DARK_GREY)
         .withLabelText("labelText")
         .withValueBackgroundColor(SVGImageColor.GREEN)
         .withValueText("1.0.0")
         .withTemplate(template)
         .build();
      
      System.err.println(ig.buildFor(data));
   }
}
