# Products App

## Prerequisites

- Java 21
- Node.js 22+
- Docker Desktop

## Database setup

Start Postgres:

```bash
docker compose up -d
```

Database runs on:
- port: 5432
- db: products
- user: postgres
- password: postgres

## Start backend

```bash
cd backend
./gradlew bootRun
```

Backend runs on:
http://localhost:8080

## Start frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend runs on:
http://localhost:5173

## Verify

1. Open http://localhost:5173
2. Create a product named `P1`
3. Confirm `P1` appears in the product list

## How I built it

- Started with the most narrow defined requirements for the backend: Flyway migration, repository, service, REST endpoint(s).
- Use AI for the frontend. Iterate until the frontend sends a valid request to the backend to persist
- Chose a Vite development proxy so local frontend-to-backend calls need no CORS configuration.
- With more time, I would add a Postgres-backed repository integration test using Testcontainers and return a consistent API error body for validation failures.

