package org.sekaijin.maven.plugin.badge;

import org.junit.Test;
import org.sekaijin.maven.plugin.badge.font.FontProvider;
import org.sekaijin.maven.plugin.badge.font.FontProviderLocator;
import org.sekaijin.maven.plugin.badge.svg.SVGImageColor;
import org.sekaijin.maven.plugin.badge.svg.SVGImageData;
import org.sekaijin.maven.plugin.badge.svg.SVGImageGenerator;
import org.sekaijin.maven.plugin.badge.svg.SVGImageTemplate;

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
         .withLabelText("badge-maven")
         .withValueBackgroundColor(SVGImageColor.GREEN)
         .withValueText("1.0.0-SNAPSHOT")
         .withTemplate(template)
         .build();
      
      System.err.println(ig.buildFor(data));
   }
}
