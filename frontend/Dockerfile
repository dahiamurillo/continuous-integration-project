FROM node:latest as node

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build --prod

CMD [ "npm", "start" ]

FROM nginx:1.23-alpine
COPY --from=node /app/dist/frontend /usr/share/nginx/html