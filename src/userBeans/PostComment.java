package userBeans;

public class PostComment {
	
	PostCommentDao pcdao = new PostCommentDao();
	
	public void AddWordPostComment(String postID, String postUser, String postDate, String comment){

		String postcomments = pcdao.getWordPostCommentsInDB(postID); // get current comments
		if(postcomments == null){
			postcomments = ""; // initialize if null
		}		
		
		UserBean ud = new UserBean();
		String image = ud.getProfileImage(postUser);
		
		
		String comments = postcomments + " !X " + "<img src="+image+" class=\"resizeUserImgComment\"> <strong>"+postUser+":</strong> "+comment; //add comment
			
		pcdao.AddCommentsWordPostInDB(postID,comments);
		
	}
	public void AddQuotePostComment(String postID, String postUser, String postDate, String comment){

		String postcomments = pcdao.getQuotePostCommentsInDB(postID); // get current comments

		if(postcomments == null){
			postcomments = ""; // initialize if null
		}		
		
		UserBean ud = new UserBean();
		String image = ud.getProfileImage(postUser);
		
		
		String comments = postcomments + " !X " + "<img src="+image+" class=\"resizeUserImgComment\"> <strong>"+postUser+":</strong> "+comment; //add comment
			
		pcdao.AddCommentsQuotePostInDB(postID,comments);

		
	}
	public void AddWordListComment(String postID, String postUser, String postDate, String comment){

		String postcomments = pcdao.getWordListCommentsInDB(postID); // get current comments
		if(postcomments == null){
			postcomments = ""; // initialize if null
		}		
		
		UserBean ud = new UserBean();
		String image = ud.getProfileImage(postUser);
		
		
		String comments = postcomments + " !X " + "<img src="+image+" class=\"resizeUserImgComment\"> <strong>"+postUser+":</strong> "+comment; //add comment
			
		pcdao.AddCommentsWordListInDB(postID,comments);
		
	}
	public void AddQuoteListComment(String postID, String username, String postDate, String comment) {
		// TODO Auto-generated method stub
		
	}
	

}
