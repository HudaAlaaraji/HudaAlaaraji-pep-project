You will need to design and create your own Service classes from scratch.
You should refer to prior mini-project lab examples and course material for guidance.




public class SocialMediaService {
    public SocialMediaDAO socialmediaDAO;

    public SocialMediaService(){
        socialmediaDAO = new SocialMediaDAO();
    }

    public SocialMediaService(SocialMediaDAO socialmediaDAO){
        this.socialmediaDAO = socialmediaDAO;
    }
