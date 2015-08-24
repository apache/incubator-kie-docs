<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

  <xsl:template match="/root">
    <xsl:for-each select="code">
      <xsl:result-document method="xml" href="target/examples/{@id}.java">
        <root>
          <xsl:copy-of select="/root/@*" />
          <elem>
            <xsl:copy-of select="../@* | ." />
          </elem>
        </root>
      </xsl:result-document>
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>