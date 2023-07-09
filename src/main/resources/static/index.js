
  function descargarArchivo(){
    axios({
        url: '/api/archivos/1', // Reemplaza 123 con el ID del archivo deseado
        method: 'GET',
        responseType: 'arraybuffer' // Indica que se espera una respuesta en formato arraybuffer
      }).then(response => {
        const nombreArchivo = obtenerNombreArchivo(response); // Obtén el nombre del archivo según tu lógica
        
        const blob = new Blob([response.data], { type: response.headers['content-type'] });
        const url = window.URL.createObjectURL(blob);
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', nombreArchivo);
        document.body.appendChild(link);
        link.click();
      });
  }
  function obtenerNombreArchivo(response) {
    const contentDisposition = response.headers['content-disposition'];
    const regex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
    const matches = regex.exec(contentDisposition);
    
    if (matches != null && matches[1]) {
      return matches[1].replace(/['"]/g, '');
    }
    
    return 'archivo_descargado'; // Establece un nombre predeterminado si no se puede obtener el nombre del archivo
  }
  function subirArchivo() {
    const archivoInput = document.getElementById('archivoInput');
    const archivo = archivoInput.files[0];

    const formData = new FormData();
    formData.append('files', archivo);

    axios.post(`/api/client/${1}/files/upload`, formData)
      .then(response => {
        console.log('Archivo subido correctamente');
      })
      .catch(error => {
        console.error('Error al subir el archivo:', error);
      });
  }