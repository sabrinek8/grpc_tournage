package User;

import com.reparti.grpc.User.APIResponse;
import com.reparti.grpc.User.Empty;
import com.reparti.grpc.User.LoginRequest;
import com.reparti.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
	System.out.println("Inside LogIn !");
	String username= request.getUsername();
	String password=request.getPassword();
	
	APIResponse.Builder response=APIResponse.newBuilder();
	if(username.equals(password))
	{
		response.setResponseCode(0).setResponsemessage("Success");
	}
	else {
		response.setResponseCode(100).setResponsemessage("Failure");
	}
	responseObserver.onNext(response.build());
	responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
