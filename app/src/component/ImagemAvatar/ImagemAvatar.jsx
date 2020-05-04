import React from 'react'
import { Image } from 'semantic-ui-react'

const ImagemAvatar = () => (
  <div>
    <Image src={this.props.imagemPerfil} avatar />
    <span>Username</span>
  </div>
)

export default ImagemAvatar