import React from 'react'

export default function list(props) {
  return (
    <div class={ props.name } role="alert">
        <span> { props.message }</span>
    </div>
  )
}
