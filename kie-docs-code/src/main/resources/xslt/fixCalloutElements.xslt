<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:xs="http://www.w3.org/2001/XMLSchema" 
    xmlns:docs="http://docs.kie.org/"
    exclude-result-prefixes="xsl xs docs"
    version="2.0">

  <xsl:function name="docs:substring-after-last" as="xs:string">
    <xsl:param name="arg" as="xs:string?" />
    <xsl:param name="delim" as="xs:string" />
    <xsl:sequence select="replace ($arg,concat('^.*',$delim),'')" />
  </xsl:function>

  <xsl:template match="co">
    <xsl:variable name="file" select="substring-before(docs:substring-after-last(base-uri(), '/'), '.')" />
    <xsl:variable name="id" select="@linkends" />
    <co id="{$file}-{$id}-co" linkends="{$file}-{$id}" />
  </xsl:template>

  <!-- Copy everything else. -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()" />
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>