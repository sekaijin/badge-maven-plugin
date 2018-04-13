package fr.aphp.ati.eai.olympe.maven.plugin.badge;

import org.junit.Test;

import fr.aphp.ati.eai.olympe.maven.plugin.badge.svg.SVGImageColor;

public class BadgeTest
{
   @Test
   public void makeTest() throws Exception {
      System.setProperty("java.net.useSystemProxies", "true");
      Badge badge = new Badge();
      badge.setName("name");
      badge.setVersion("1.0.0");
      badge.setColor(SVGImageColor.GREEN);

      BadgeMojo mojo = new BadgeMojo();
      mojo.makeBadge(badge);
   }

}
