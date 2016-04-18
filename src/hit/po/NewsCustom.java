package hit.po;

public class NewsCustom extends News {
		private String author;
		private String newsTime;
		private String newsSummary;
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getNewsTime() {
			return newsTime;
		}
		public void setNewsTime(String newsTime) {
			this.newsTime = newsTime;
		}
		public String getNewsSummary() {
			return newsSummary;
		}
		public void setNewsSummary(String newsSummary) {
			this.newsSummary = newsSummary;
		}
	
		
}
