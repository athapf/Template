<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:import href="./data/data.xslt"/>
    <xsl:import href="./data/mapper.xslt"/>
    <xsl:import href="./resources/resources.xslt"/>
    <xsl:import href="./kafka/topic.xslt"/>

    <xsl:template match="komponent">
        <xsl:apply-templates select="./descendant::dto"/>
        <xsl:apply-templates select="./descendant::dto" mode="mapper"/>
        <xsl:apply-templates select="./descendant::entity" mode="value"/>
        <xsl:apply-templates select="./descendant::consumer"/>
        <xsl:apply-templates select="./descendant::producer"/>
        <xsl:apply-templates select="./descendant::resources"/>
    </xsl:template>
</xsl:stylesheet>
