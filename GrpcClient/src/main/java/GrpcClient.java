import com.reparti.grpc.userGrpc;
import com.reparti.grpc.User.APIResponse;
import com.reparti.grpc.User.LoginRequest;
import com.reparti.grpc.User.LoginRequest.Builder;
import com.reparti.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {
		ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

		
		//stubs generation
		userBlockingStub userStub=userGrpc.newBlockingStub(channel);
		
		
		LoginRequest loginrequest=LoginRequest.newBuilder().setUsername("Sabrine").setPassword("Sabrine").build();
		APIResponse response=userStub.login(loginrequest);
		System.out.println(response.getResponsemessage());
	}

}
