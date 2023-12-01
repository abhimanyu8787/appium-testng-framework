package appium.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtility {
	
	public static Response orderListResponse;
	
	public static Response getOrderListAPIResponse() {
        RestAssured.baseURI = "https://www.nykaa.com";
        String endpoint = "/gateway-api/omsApis/v1/orderList";
        String queryParams = "?currentPage=0&offset=10&email=creativeabhimanyu%40gmail.com&domain=NYKAA";
        String cookie="bcookie=5a156698-801b-498c-8711-bf20edc3946b; EXP_ADP_RV_REORDER=A; EXP_ADP_RV_SEGMENT=A; EXP_AB_AUTOFILL=B; EXP_ADP_RV_VIEW_SIMILAR=A; EXP_ADP_RV_PLP_CONFIGURABLE_NO_RESULTS=A; EXP_ADP_RV_PRODUCT_V3=CONTROL; EXP_CART_LOGIN_SEGMENT=A; EXP_AB_WISHLIST=A; EXP_AB_PRICE_REVEAL_NEW=A; EXP_PLP_INLINE_FILTER=A; EXP_EDD_DELIVERY_WIDGET=A; EXP_ADP_RV_MULTI_COUPONS=A; EXP_AB_DWEB_MULTICOUPON=D; EXP_ADP_RV_SEARCH_BAR_NEW=A; EXP_VIEW_TRANSITION=A; EXP_AB_AUTH_PAGE=A; EXP_AB_AUTH_DWEB=CONTROL; EXP_INCORRECT_SLUG_REDIRECT=A; EXP_SLP_RELATED_SEARCHES=A; EXP_QUERY_PARAM_EXP=CONTROL; EXP_AB_OFFER_REVAMP=A; EXP_ORGANIC_GUIDES=A; EXP_AB_NEW_PLP=A; run=98; EXP_REVIEW_COLLECTION=1; D_LST=1; D_PDP=1; d_info=2560_1440; _gcl_au=1.1.1733575911.1700251870; mfKey=ftm6cz.1700251870039; EXP_PLP_PINKBOX_CTA=CONTROL; EXP_AB_BEST_PRICE=CONTROL; EXP_AB_CALLOUT_NUDGE=A; EXP_UPDATED_AT=1700756635264; EXP_SSR_CACHE=edf5128dd14b5a4215cbb81bd2cb41a4; _cfuvid=vgo1s1gmTGr6zEdl8giF3.wtXAxyu2gqXmvQmyrBAtM-1700939105875-0-604800000; cf_clearance=10FQ0sCunhvqsEBWfe9N7VAxxsWiRJ.fL2AZC6tDhsM-1700939106-0-1-b15cba16.d5300f10.e65de5f6-0.2.1700939106; PHPSESSID=k576eqqb3vv6nh3m4geva6vcj6; pro=false; AMCVS_FE9A65E655E6E38A7F000101%40AdobeOrg=1; s_cc=true; _gid=GA1.2.1683983064.1700939110; SHOW_PREVIEW_INFO_PAGE=false; OLD_LISTING_FLOW=false; GC_PREVIEW_EXPERIMENT=false; C_AUTH=true; DESKTOP_REVAMP=1; VIEW_COUPON_EXPERIMENT=true; N_A_P=1; N_P_S_P=1; N_S_B_P=1; GIFTCARD_REVAMP=1; GIFTCARD_REVAMP_DESKTOP=1; NEW_MY_SAVED_PAYMENT_PAGE=1; NEW_ORDERLISTING_PAGE=true; NEW_ORDERDETAIL_PAGE=true; countryCode=IN; frontendSource=react; N_R_S=0; mfe=0; OPEN_NATIVE_ORDER_CONFIRMATION=1; P_C_I=0; PCI=1; U_I_R=0; PAYMENT_BACK_FRICTION=1; UPI_V=1; COD_NUDGE=1; C_P_M=1; C_P_D=1; O_D_I=1; P_O_W=1; N_W_P_P=1; N_W_P_P_D=1; N_O_C_P_D=1; S_S_B_S=0; SAVED_CC_OPT=0; CCUC=1; SCCUC=0; O_L_I=1; N_S_B=1; N_S_B_I=1; N_P_P_C=0; S_R_M=1; O_P_R=0; CC_SAVE_OPT=0; N_S_A_W=1; M_C_F=1; GPAY_INTENT=1; D_HOM=1; N_CMS=1; form_key=thVwQlMfhGubq1KY; disableSmartLogin=true; clearLocalStorageLogin=1; googlelogin=1; googlelogincustid=17106740; googlelogincustemail=creativeabhimanyu%40gmail.com; __cfruid=7015222230bf89c2b0f824c56d568a5084d3b9f7-1700939115; head_data_react={\"id\":\"17106740\",\"nykaa_pro\":0,\"group_id\":\"1\"}; undefined=false; storeId=nykaa; emailVerified=true; NYK_VISIT=5a156698-801b-498c-8711-bf20edc3946b~1700940008856; NYK_PCOUNTER=1; NYK_ECOUNTER=1; C_DFA=0; N_PV=1; Z_V_1=false; Z_V_2=false; Z_VISIBILITY=true; gpv_p2=nykaa; SITE_VISIT_COUNT=10; s_nr365=1700940052387-Repeat; mf_visitid=6f8bs3.1700940054870; mf_utms=%7B%22ptype%22%3A%22myWishlist%22%7D; _ga_JQ1CQHSXRX=GS1.2.1700939110.2.1.1700940055.38.0.0; s_sq=fsnecommerceprod%3D%2526c.%2526a.%2526activitymap.%2526page%253DWeb%25253ANykaa%25253AWishlist%2526link%253DMy%252520Orders%2526region%253Dapp%2526pageIDType%253D1%2526.activitymap%2526.a%2526.c%2526pid%253DWeb%25253ANykaa%25253AWishlist%2526pidt%253D1%2526oid%253Dfunctioncn%252528%252529%25257B%25257D%2526oidt%253D2%2526ot%253DA; AMCV_FE9A65E655E6E38A7F000101%40AdobeOrg=359503849%7CMCIDTS%7C19687%7CMCMID%7C61537453887671783142576532940416819495%7CMCAAMLH-1701544939%7C12%7CMCAAMB-1701544939%7C6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y%7CMCOPTOUT-1700947339s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C5.0.1; __cf_bm=grvqru.xJryAAxaAHvCevKp1IZ2.amjbETSYYbE6exQ-1700940140-0-AbXLwr4cnwux9/UBAeDjzYooVQ+Tjrhwu7gosvwqS2qjcrOwufpNEs6UYSXp7acA8T5Oyg+fWOG+GAsHNUxXBvw=; _ga_LKNEBVRZRG=GS1.1.1700939110.2.1.1700940141.58.0.0; _ga=GA1.2.854721590.1700251870; _gat_UA-31866293-9=1";
        orderListResponse = RestAssured.given()
            .header("authority", "www.nykaa.com")
            .header("accept", "application/json, text/plain, */*")
            .header("accept-language", "en-US,en;q=0.9")
            .header("cookie", cookie)
            .header("referer", "https://www.nykaa.com/myOrderIframe/list")
            .header("request-starttime", "1700940141933")
            .header("x-csrf-token", "thVwQlMfhGubq1KY")
        .when()
            .get(endpoint + queryParams)
        .then()
            .statusCode(200)
            .extract()
            .response();

        String responseBody = orderListResponse.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        return orderListResponse;
	}

}
