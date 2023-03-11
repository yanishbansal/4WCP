# syntax=docker/dockerfile:1

FROM node:alpine3.10

WORKDIR /star_frontend

COPY ./package.json /star_frontend

RUN npm install 

CMD ["npm", "start"]

EXPOSE 3001






