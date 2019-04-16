# Keycloack sample

curl -d "client_id=test-client" -d "username=test-user" -d "password=test-pass" -d "grant_type=password" "http://localhost:8080/auth/realms/test/protocol/openid-connect/token"