package Location.project.api.infra;

import Location.project.api.domain.DadosEndereco;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private GeoApiContext geoApiContext;

    public DadosEndereco obterEndereco(String lat, String lng) {
        try {
            GeocodingResult[] results = GeocodingApi.reverseGeocode(geoApiContext,
                    new com.google.maps.model.LatLng(Double.parseDouble(lat), Double.parseDouble(lng))).await();
            if (results != null && results.length > 0) {
                String endereco = results[0].formattedAddress;
                return new DadosEndereco(endereco);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DadosEndereco("Erro ao obter o endereço: " + e.getMessage());
        }
    }
}
