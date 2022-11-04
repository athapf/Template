<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:import href="../old/resources/resources.xslt"/>
    <xsl:import href="../old/controller.xslt"/>
    <xsl:import href="../old/topics/topics.xslt"/>
    <xsl:import href="../old/entity.xslt"/>
    <xsl:import href="../old/cassandra/cassandra.xslt"/>
    <xsl:import href="../old/cassandra/initdb.xslt"/>

    <xsl:template match="komponent">
        <xsl:apply-templates select="./resources"/>
        <xsl:apply-templates select="./topics"/>
        <xsl:apply-templates select="./resources/resource" mode="controller"/>
        <xsl:apply-templates select="./datacatalog/entity"/>
        <xsl:apply-templates select="./database"/>
        <xsl:apply-templates select="./datacatalog" mode="cassandra"/>
    </xsl:template>
</xsl:stylesheet>
