package CWK02;

import java.util.List;

public interface gymManager {
    public void addAMember(defaultMember member);
    public void deleteMember(defaultMember membershipNo);
    public void printList();
    public List<defaultMember> sortFile();
    public void saveFile();
    public List<defaultMember> getMemberList();
    public defaultMember getMemberByMembershipNo (String membershipNo);
    public defaultMember [] getMemberByName (String memberName);
    public void openApplication();

}
