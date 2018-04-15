package org.sekaijin.maven.plugin.badge;

import org.junit.Test;
import org.sekaijin.maven.plugin.badge.Badge;
import org.sekaijin.maven.plugin.badge.BadgeMojo;
import org.sekaijin.maven.plugin.badge.svg.SVGImageColor;

public class BadgeTest
{
   @Test
   public void makeValueTest() throws Exception {
      System.setProperty("java.net.useSystemProxies", "true");
      Badge badge = new Badge();
      badge.setName("name");
      badge.setVersion("1.0.0");
      badge.setColor(SVGImageColor.GREEN);

      BadgeMojo mojo = new BadgeMojo();
      System.err.println(mojo.makeBadge(badge));
   }

   @Test
   public void makeTest() throws Exception {
      System.setProperty("java.net.useSystemProxies", "true");
      Badge badge = new Badge();
      badge.setName("name");
//      badge.setVersion("1.0.0");
//      badge.setColor(SVGImageColor.GREEN);

      BadgeMojo mojo = new BadgeMojo();
      System.err.println(mojo.makeBadge(badge));
   }
}
