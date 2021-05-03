import SwiftUI
import shared
import MapKit



//KMM sample
//let greet = Greeting().greeting()
//Text(greet)


struct MapPage: View {
    
    @State private var isActiveGetInPage:Bool = false
    //TODO: get current locations from user
    @State private var region: MKCoordinateRegion = MKCoordinateRegion(center: CLLocationCoordinate2D(latitude: 40.75773, longitude: -73.985708), span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05))
    @State private var pointsOfInterest:[AnnotatedItem] = []

    @State private var latitude = 40.75773
    @State private var longitude = -73.985708
    
    var body: some View {
        
        NavigationView {
            ZStack(alignment: .bottomTrailing)  {
                
                Map(
                    coordinateRegion: $region,
                    showsUserLocation: true,
                    userTrackingMode: .constant(.follow),
                    annotationItems: pointsOfInterest
                ) { annotation in
                    MapAnnotation(coordinate: annotation.coordinate) {
                        AnnotationView(annotation: annotation)
                    }
                }
                .edgesIgnoringSafeArea(.all)
                
                
                NavigationLink(destination: GetInPage(), isActive: $isActiveGetInPage) { EmptyView() }
                
                FloatActionButtonView(image: "bus"){
                    //TODO: self.buttonClicked()
                    self.isActiveGetInPage = true
                }
                .padding(16)
                
                
            }
            .navigationBarTitle("Omnibus")
        }
    }
    
    func buttonClicked() {
        
        pointsOfInterest = [
            AnnotatedItem(number:"",name: "Eu",image: "figure.wave", coordinate: .init(latitude: 40.75773 , longitude: -73.985708)),
            AnnotatedItem(number:"021",name: "Linha 01",image: "bus", coordinate: .init(latitude: latitude , longitude: -73.985708)),
            AnnotatedItem(number:"022",name: "Linha 02",image: "bus", coordinate: .init(latitude: 40.75773 , longitude: longitude)),
        ]
        
        self.latitude = self.latitude + 0.001
        self.longitude = self.longitude + 0.001
    }
    
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        MapPage()
    }
}
