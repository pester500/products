import { useEffect, useState } from 'react'

export default function App() {
  const [products, setProducts] = useState([])
  const [name, setName] = useState('')

  async function loadProducts() {
    const response = await fetch('http://localhost:8080/api/products')
    const data = await response.json()
    setProducts(data)
  }

  async function createProduct() {
    await fetch('http://localhost:8080/api/products', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ name })
    })

    setName('')
    loadProducts()
  }

  useEffect(() => {
    loadProducts()
  }, [])

  return (
    <div style={{ padding: '20px' }}>
      <h1>Products</h1>

      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Product name"
      />

      <button onClick={createProduct}>
        Create
      </button>

      <ul>
        {products.map(product => (
          <li key={product.id}>{product.name}</li>
        ))}
      </ul>
    </div>
  )
}