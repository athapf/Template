<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:param name="OutputBaseDirectory"/>
    <xsl:param name="KomponentPath"/>

    <xsl:include href="../generate/utils/text.xslt"/>

    <xsl:template match="field" mode="dto-variable">
        <xsl:param name="indent"></xsl:param>
        <xsl:value-of select="$indent"/>
        <xsl:text>    private </xsl:text>
        <xsl:value-of select="./@type"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text>;&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="field" mode="dto-param">
        <xsl:if test="position()&gt;1">
            <xsl:text>,</xsl:text>
        </xsl:if>
        <xsl:text>&#xA;            final </xsl:text>
        <xsl:value-of select="./@type"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
    </xsl:template>

    <xsl:template match="field" mode="dto-assign">
        <xsl:text>        this.</xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text> = </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text>;&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="field" mode="dto-to-string">
        <xsl:text>            "</xsl:text>
        <xsl:if test="position()&gt;1">
            <xsl:text>, </xsl:text>
        </xsl:if>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text>='" + </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text> + '\'' +&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="field" mode="dto-setter-getter">
        <xsl:text>    public </xsl:text>
        <xsl:value-of select="./@type"/> get<xsl:value-of select="./@name"/>
        <xsl:text>() {&#xA;</xsl:text>
        <xsl:text>        return </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text>;&#xA;</xsl:text>
        <xsl:text>    }&#xA;</xsl:text>
        <xsl:text>    public void set</xsl:text>
        <xsl:value-of select="./@name"/>
        <xsl:text>(final </xsl:text>
        <xsl:value-of select="./@type"/>
        <xsl:text> value) {&#xA;</xsl:text>
        <xsl:text>        this.</xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text> = value;&#xA;</xsl:text>
        <xsl:text>    }&#xA;</xsl:text>
        <xsl:text>&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="field" mode="dto-with">
        <xsl:text>        public Builder with</xsl:text>
        <xsl:value-of select="./@name"/>
        <xsl:text>(final </xsl:text>
        <xsl:value-of select="./@type"/>
        <xsl:text> value) {&#xA;</xsl:text>
        <xsl:text>            this.</xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text> = value;&#xA;</xsl:text>
        <xsl:text>            return this;&#xA;</xsl:text>
        <xsl:text>        }&#xA;</xsl:text>
        <xsl:text>&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="field" mode="dto-build">
        <xsl:text>            result.</xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text> = </xsl:text>
        <xsl:value-of select="translate(./@name,$upper,$lower)"/>
        <xsl:text>;&#xA;</xsl:text>
    </xsl:template>

    <xsl:template match="dto">
        <xsl:variable name="subpackage">
            <xsl:choose>
                <xsl:when test="../name()='resource'">rest.dto</xsl:when>
                <xsl:when test="../name()='producer'">kafka.dto</xsl:when>
                <xsl:when test="../name()='consumer'">kafka.dto</xsl:when>
                <xsl:otherwise>dto</xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:variable name="entity-name" select="./@entity"/>
        <xsl:variable name="package" select="concat(translate($KomponentPath,'/','.'),'.',translate(/komponent/@name,$upper,$lower),'.',$subpackage)"/>
        <xsl:variable name="classname" select="concat(./@name,'Dto')"/>
        <xsl:variable name="filename" select="concat($OutputBaseDirectory,'/',translate($package,'.','/'),'/',$classname,'.java')"/>
        <xsl:variable name="fields" select="/komponent/datacatalog/entity[./@name=$entity-name]/field"/>

        <xsl:result-document href="{$filename}">
            <xsl:text>package </xsl:text>
            <xsl:value-of select="$package"/>
            <xsl:text>;&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>import java.math.BigDecimal;&#xA;</xsl:text>
            <xsl:text>import java.util.Date;&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>public class </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text>{&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-variable"/>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>    public </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text>() {}&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>    public </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text>(</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-param"/>
            <xsl:text>) {&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-assign"/>
            <xsl:text>    }&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>    @Override&#xA;</xsl:text>
            <xsl:text>    public String toString() {&#xA;</xsl:text>
            <xsl:text>        return "</xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text>{" +&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-to-string"/>
            <xsl:text>            '}';&#xA;</xsl:text>
            <xsl:text>    }&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-setter-getter"/>
            <xsl:text>    public static Builder builder() {&#xA;</xsl:text>
            <xsl:text>        return new Builder();&#xA;</xsl:text>
            <xsl:text>    }&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:text>    public static class Builder {&#xA;</xsl:text>
            <xsl:text>        private Builder() {}&#xA;</xsl:text>
            <xsl:text>&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-variable">
                <xsl:with-param name="indent" select="'    '"/>
            </xsl:apply-templates>
            <xsl:text>&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-with"/>
            <xsl:text>        public </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text> build() {&#xA;</xsl:text>
            <xsl:text>            final </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text> result = new </xsl:text>
            <xsl:value-of select="$classname"/>
            <xsl:text>();&#xA;</xsl:text>
            <xsl:apply-templates select="$fields" mode="dto-build"/>
            <xsl:text>            return result;&#xA;</xsl:text>
            <xsl:text>        }&#xA;</xsl:text>
            <xsl:text>    }&#xA;</xsl:text>
            <xsl:text>}&#xA;</xsl:text>
        </xsl:result-document>
    </xsl:template>
</xsl:stylesheet>
