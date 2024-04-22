const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');

// Load the .proto file
const packageDefinition = protoLoader.loadSync('path/to/your/file.proto', {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true
});

// Get the package
const yourProtoPackage = grpc.loadPackageDefinition(packageDefinition).yourPackageName;

// Create a gRPC client
const client = new yourProtoPackage.YourService('localhost:50051', grpc.credentials.createInsecure());

// Call a method on the client
client.yourMethod({ your: 'data' }, function(error, response) {
  if (error) {
    console.error('Error: ', error);
  } else {
    console.log('Response: ', response);
  }
});