package net.quaerofuture.facebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.googlecode.batchfb.FacebookBatcher;
import com.googlecode.batchfb.PagedLater;
import com.googlecode.batchfb.err.OAuthAccessTokenException;
import com.googlecode.batchfb.err.OAuthException;

/**
 * Cette classe est la classe principale utilisé pour effetctuer les différentes requêtes sur Facebook.
 * 
 * @author Herilaza
 *
 */
public class FacebookGrabber implements IFacebookGrabber{
	
	private static final String AUTH_URL = "https://www.facebook.com/dialog/oauth?response_type=token&redirect_uri=https://www.facebook.com/connect/login_success.html";
	private static final String CLIENT_ID_PARAM_NAME = "client_id";
	private static final String SCOPE_PARAM_NAME = "scope";
	
	private static final String FACEBOOK_LOGIN_FORM_ID = "login_form";
	private static final String FACEBOOK_LOGIN_INPUT_EMAIL_NAME = "email";
	private static final String FACEBOOK_LOGIN_INPUT_PASSWORD_NAME = "pass";
	private static final String FACEBOOK_LOGIN_INPUT_SUBMIT_BUTTON_NAME = "login";
	
	private static final String FACEBOOK_PERMISSION_REQUEST_FORM_ID = "uiserver_form";
	private static final String FACEBOOK_PERMISSION_REQUEST_ALLOW_BUTTON_NAME = "grant_clicked";
	
	private static final String FACEBOOK_ERROR_LOGIN_ID = "error";
	private static final String FACEBOOK_APPLICATION_ERROR = "platform_dialog_content";
	
	private static final String OAUTH_ACCESS_TOKEN_EXPIRED = "Session has expired";
	
	
	private FacebookBatcher fBatcher;
	
	private String urlLogin;
	private String userMail;
	private String userPass;
	private String accessToken;
	
	/**
	 * @param userMail e-mail d'un utilisateur Facebook
	 * @param password mot de passe de l'utilisateur Facebook
	 * @param AppID Application ID de l'application Facebook
	 * @throws FacebookPageAuthException
	 * @throws FacebookUserAuthException 
	 */
	public FacebookGrabber(String userMail, String password, String AppID) throws FacebookException{
		
		urlLogin = AUTH_URL+"&"+CLIENT_ID_PARAM_NAME+"="+AppID;
		this.userMail = userMail;
		this.userPass = password;
		this.accessToken = getAccessToken(this.userMail,userPass,urlLogin);
		fBatcher = new FacebookBatcher(accessToken);
	}
	
	/**
	 * @param userMail e-mail d'un utilisateur Facebook
	 * @param password mot de passe de l'utilisateur Facebook
	 * @param AppID Application ID de l'application Facebook
	 * @param permissions Liste des permissions que l'application requiert 
	 * @throws FacebookPageAuthException
	 * @throws FacebookUserAuthException
	 */
	public FacebookGrabber(String userMail, String password, String AppID, List<String> permissions) {
		String paramPermValue = null;
		for (String perm : permissions) {
			if (paramPermValue == null) {
				paramPermValue = perm;
			}
			else {
				paramPermValue = paramPermValue+","+perm;
			}
		}
		urlLogin = AUTH_URL+"&"+CLIENT_ID_PARAM_NAME+"="+AppID+"&"+SCOPE_PARAM_NAME+"="+paramPermValue;
		this.userMail = userMail;
		this.userPass = password;
		this.accessToken = getAccessToken(this.userMail,userPass,urlLogin);
		
		fBatcher = new FacebookBatcher(accessToken);
		
	}

	/* (non-Javadoc)
	 * @see net.quaerofuture.facebook.IFacebookGrabber#loadAllComment(net.quaerofuture.facebook.FacebookPost)
	 */
	@Override
	public void loadAllComment(FacebookPost p) {
		List<FacebookCommentItem> lCom = new ArrayList<FacebookCommentItem>();
		PagedLater<FacebookCommentItem> com = null;
		try {
			com = fBatcher.paged(p.getId()+"/comments",FacebookCommentItem.class);
		}
		catch (OAuthAccessTokenException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				loadAllComment(p);
			}
			else {
				e.printStackTrace();
			}
		}
		while (com != null) {
			lCom.addAll(com.get());
			try {
				com = com.next();
			}
			catch(Exception e) {
				com = null;
			}
		}
		p.getComments().setData(lCom);
	}
	
	/* (non-Javadoc)
	 * @see net.quaerofuture.facebook.IFacebookGrabber#readPage(java.lang.String)
	 */
	@Override
	public FacebookPage readPage(String pageID) {
		FacebookPage page = null;
		try {
			page = fBatcher.graph(pageID,FacebookPage.class).get();
		}
		catch (OAuthAccessTokenException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				page = readPage(pageID);
			}
			else {
				e.printStackTrace();
			}
		}
		return page;
	}
	
	/* (non-Javadoc)
	 * @see net.quaerofuture.facebook.IFacebookGrabber#readUser(java.lang.String)
	 */
	@Override
	public FacebookUser readUser(String userID) {
		FacebookUser user = null;
		try {
			user = fBatcher.graph(userID,FacebookUser.class).get();
		}
		catch (OAuthException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				user = readUser(userID);
			}
			else {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	/* (non-Javadoc)
	 * @see net.quaerofuture.facebook.IFacebookGrabber#readWall(java.lang.String, boolean)
	 */
	@Override
	public List<FacebookPost> readWall(String id, boolean loadAllComments) {
		List<FacebookPost> lPost = new ArrayList<FacebookPost>();
		PagedLater<FacebookPost> post = null;
		try {
			post = fBatcher.paged(id+"/feed",FacebookPost.class);
		}
		catch (OAuthAccessTokenException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				lPost = readWall(id, loadAllComments);
			}
			else {
				e.printStackTrace();
			}
		}
		if (loadAllComments) {
			while (post != null) {
				for (FacebookPost p : post.get()) {
					if (p.getComments().getCount() > 2) {
						loadAllComment(p);
					}
					lPost.add(p);
				}
			post = post.next();
			}
		}
		else {
			while (post!=null) {
				lPost.addAll(post.get());
				post = post.next();
			}
		}
		
		return lPost;
	}
	
	/**
	 * Excecute une requête permettant de récuperer la liste des "post" Facebook sur un mur d'une page ou d'un utlisateur entre deux date (since et until)
	 * @param id l'Identifiant de l'utilisateur ou de la page Facebook
	 * @param loadAllComments  permettant de savoir si on veut ou non charger toutes les commentaires sur un post, si true, on charge toutes les commentaires, false sinon
	 * @param since la date de debut, depuis laquelle on veut charger les posts
	 * @param until la date de fin, jusqu'a laquelle on veut charger les posts
	 * @return la liste des "posts" entre ces deux dates
	 */
	public List<FacebookPost> readWall(String id, boolean loadAllComments,Date since,Date until) {
		String req = id+"/feed?since="+convertToSeconds(since.getTime())+"&until="+convertToSeconds(until.getTime());
		List<FacebookPost> lPost = new ArrayList<FacebookPost>();
		PagedLater<FacebookPost> post = null;
		try {
			post = fBatcher.paged(req,FacebookPost.class);
		}
		catch (OAuthAccessTokenException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				lPost = readWall(id,loadAllComments,since,until);
			}
			else {
				e.printStackTrace();
			}
		}
		if (loadAllComments) {
			while (post != null) {
				for (FacebookPost p : post.get()) {
					if (p.getCreatedTimeAsDate().getTime() < since.getTime()) {
						post = null;
						return lPost;
					}
					if (p.getComments().getCount() > 2) {
						loadAllComment(p);
					}
					lPost.add(p);
				}
			post = post.next();
			}
		}
		else {
			while (post!=null) {
				for(FacebookPost p : post.get()) {
					if (p.getCreatedTimeAsDate().getTime() < since.getTime()) {
						post = null;
						return lPost;
					}
					lPost.add(p);
				}
				post = post.next();
			}
		}
		
		return lPost;
	}
	
	/**
	 * Excecute une requête permettant de récuperer la liste des "N-post" Facebook les plus récents sur un mur d'une page ou d'un utlisateur
	 * @param id l'Identifiant de l'utilisateur ou de la page Facebook
	 * @param loadAllComments permettant de savoir si on veut ou non charger toutes les commentaires sur un post, si true, on charge toutes les commentaires, false sinon
	 * @param limit le nombre de post à charger
	 * @return la liste des "N-posts" du plus récent au plus ancien
	 */
	public List<FacebookPost> readWall(String id, boolean loadAllComments, int limit) {
		List<FacebookPost> lPost = new ArrayList<FacebookPost>();
		PagedLater<FacebookPost> post = null;
		try {
			post = fBatcher.paged(id+"/feed",FacebookPost.class);
		}
		catch (OAuthAccessTokenException e) {
			if (e.getMessage().contains(OAUTH_ACCESS_TOKEN_EXPIRED)) {
				fBatcher = new FacebookBatcher(getAccessToken(userMail,userPass,urlLogin));
				lPost = readWall(id,loadAllComments,limit);
			}
			else {
				e.printStackTrace();
			}
		}
		if(loadAllComments) {
			while (post != null) {
				for (FacebookPost p : post.get()) {
					if (p.getComments().getCount() > 2) {
						loadAllComment(p);
					}
					lPost.add(p);
					limit--;
					if (limit == 0) {
						post = null;
						return lPost; 
					}
					
				}
				post = post.next();
			}
			return lPost;
		}
		else {
			while (post != null) {
				for (FacebookPost p : post.get()) {
					lPost.add(p);
					limit--;
					if (limit == 0) {
						post = null;
						return lPost; 
					}
					
				}
				post = post.next();
			}
			return lPost;
		}
	}
	
	private synchronized String getAccessToken(String userMail,String userPass,String url) throws FacebookException {
		//To OFF the Verbose mode off htmlunit
		
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
	    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

		final WebClient client = new WebClient();
		client.setCssEnabled(false);
		
		HtmlPage page = null ,page2 = null ,page3 = null;
		
		try {
			page = client.getPage(url);
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (page.getElementById(FACEBOOK_PERMISSION_REQUEST_FORM_ID) != null) {
			throw new FacebookPageAuthException(page.getElementById(FACEBOOK_APPLICATION_ERROR).getTextContent());
		}
		
		HtmlForm formLogin = (HtmlForm) page.getElementById(FACEBOOK_LOGIN_FORM_ID);
		HtmlSubmitInput buttonSubmit = formLogin.getInputByName(FACEBOOK_LOGIN_INPUT_SUBMIT_BUTTON_NAME);
		HtmlTextInput mail = formLogin.getInputByName(FACEBOOK_LOGIN_INPUT_EMAIL_NAME);
		HtmlPasswordInput pass = formLogin.getInputByName(FACEBOOK_LOGIN_INPUT_PASSWORD_NAME);
		mail.setValueAttribute(userMail);
		pass.setValueAttribute(userPass);
		
		try {
			page2 = buttonSubmit.click();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (page2.getElementById(FACEBOOK_ERROR_LOGIN_ID) != null) {
			throw new FacebookUserAuthException(page2.getElementById(FACEBOOK_ERROR_LOGIN_ID).getTextContent());
		}
		
		if (page2.getUrl().getRef() != null) {
			return extractAccesToken(page2.getUrl().getRef());
		}
		
		HtmlForm permission = (HtmlForm) page2.getElementById(FACEBOOK_PERMISSION_REQUEST_FORM_ID);
		HtmlInput buttonSubmit2 = permission.getInputByName(FACEBOOK_PERMISSION_REQUEST_ALLOW_BUTTON_NAME);
		try {
			page3 = buttonSubmit2.click();
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.closeAllWindows();
		return extractAccesToken(page3.getUrl().getRef());		
	}
	
	private String extractAccesToken(String str) {
		Pattern pattern = Pattern.compile("access_token=(.*)&",Pattern.DOTALL);
		Matcher match = pattern.matcher(str);
		if (match.find()) {
			return match.group(1);
		} 
		else return "false";
	}
	
	private long convertToSeconds(long time) {
		return (long) (time*Math.pow(10,-3));
	}	
}
