### STAGE 1: Build ###
FROM node:16.10-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY --from=build /usr/src/app/dist/client /usr/share/nginx/html
COPY /nginx.conf  /etc/nginx/conf.d/default.conf
CMD ["nginx","-g","daemon off;"]
