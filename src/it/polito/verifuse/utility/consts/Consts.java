package it.polito.verifuse.utility.consts;

public final class Consts {
	/**
	 * PACKAGE OF MAJOR TYPE OF DATA MANAGED
	 */
	public static final String PACKAGE_REQUIREMENTSLIST		 = "it.polito.verifuse.jaxb.requirementslist";
	public static final String PACKAGE_MANIFEST 			 = "it.polito.verifuse.jaxb.manifestvnfs";
	public static final String PACKAGE_TOOLS 			 	 = "it.polito.verifuse.jaxb.tools";
	public static final String PACKAGE_FILESUPPORT			 = "it.polito.verifuse.jaxb.filesupport";

	/**
	 * PATH USES CASES TEST
	 */
	public static final String PATH_XML_REQUIREMENTSLIST_USE_CASES 	= "UseCases/RequirementUseCase.xml";
	public static final String PATH_XML_MANIFEST_USE_CASES 			= "UseCases/ManifestVNFs.xml";
	
	/***
	 * PATH OF THE REALATIVE PACKAGE
	 */
	
	public static final String PATH_XML_REQUIREMENTSLIST 	= "xmlInputFile/RequirementsList.xml";
	public static final String PATH_XML_MANIFEST 			= "xmlInputFile/ManifestVNFs.xml";
	public static final String PATH_XML_TOOLS 				= "xmlInputFile/tools.xml";
	public static final String PATH_XML_FILESUPPORT			= "xsd/fileSupport.xml";

	public static final String PATH_XSD_REQUIREMENTSLIST 	= "xsd/RequirementsList.xsd";
	public static final String PATH_XSD_MANIFEST 			= "xsd/ManifestVNFs.xsd";
	public static final String PATH_XSD_TOOLS 				= "xsd/tools.xsd";
	public static final String PATH_XSD_FILESUPPORT 		= "xsd/fileSupport.xsd";

	/***
	 * CATEGORIES OF DATA MANAGED
	 */
	public static final String CATEGORY_FIELDS 				="FIELDS";
	public static final String CATEGORY_ACTIONS 			="ACTIONS";
	
	/***
	 * ENUMERATION OF TYPES OF DATA MANAGED
	 */
	public static final String IPSRC 						="IP_SRC";
	public static final String IPDST 						="IP_DST";

	public static final String IPSRC_v4 					="IP_SRC_VER_4";
	public static final String IPSRC_v6 					="IP_SRC_VER_6";
	public static final String IPDST_v4 					="IP_DST_VER_4";
	public static final String IPDST_v6 					="IP_DST_VER_6";

	public static final String PORTSRC 						="PORT_SRC";
	public static final String PORTDST 						="PORT_DST";
	public static final String PROTOCOL 					="PROTO";
	public static final String URLS 						="URLS";
	public static final String DOMAINS 						="DOMAINS";
	public static final String VLANTAG 						="VLAN_TAG";
	public static final String DAYSANDTIMES					="DAYS_AND_TIMES";
	public static final String DAYS							="DAY";
	public static final String TIME							="TIME";
	public static final String CONTENTDOCUMENT 				="DOCUMENTS";
	public static final String CONTENTSCRIPT 				="SCRIPTS";
	public static final String CONTENTWEBPAGES 				="WEB_PAGES";
	public static final String CONTENTAPPLICATION			="APPLICATIONS";
	public static final String CONTENTMEDIAS				="MEDIAS";
	public static final String CONTENTADVERTISING			="ADVERTISING";
	public static final String CONTENTEMAIL 				="EMAILS";
	public static final String PRIORITY 					="PRIORITY";
	public static final String BANDWIDTH 					="BANDWIDTH";
	public static final String BODY 						="BODY";
	public static final String GEOPOSITION 					="GEOPOSITION";
	public static final String DISPLACE 					="DISPLACE";
	public static final String REMARKFIELD 					="REMARK_FIELD";

	
	/***
	 * ENUMERATION OF TYPES OF DATA MANAGED
	 */
	public static final String CONSTRAINT_DENY 				="DENY_TRAFFIC";
	public static final String CONSTRAINT_ALLOW 			="ALLOW_TRAFFIC";
	
	/***
	 * ENUMERATION OF TYPES OF DATA MANAGED
	 */
	public static final String STAR 						="*";
	public static int	NUMBERTHREAD						=3;

	public static final String COMPLETE 					="COMPLETE";
	public static final String PARTIAL 						="PARTIAL";
	
	/**
	 * ENUMARATION CONFIG TYPE FIELD
	 */
	
	public static final String CONF_DEC 					="CONF_DEC";
	public static final String NOT_CONF_MAKE_DEC			="NOT_CONF_MAKE_DEC";
	public static final String NOT_CONF_NOT_DEC				="NOT_CONF_NOT_DEC";

	
	private Consts() {
	}
}
