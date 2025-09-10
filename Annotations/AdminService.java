class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed successfully!");
    }

    public void performUserTask() {
        System.out.println("User task performed successfully!");
    }
}