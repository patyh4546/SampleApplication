docker compose -f ./docker/*.yaml down &&

./mvnw clean package &&

docker compose -f ./docker/*.yaml build --no-cache &&

docker compose -f ./docker/*.yaml up -d