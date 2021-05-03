//
//  AnnotationView.swift
//  iosApp
//
//  Created by Harold Jose Barros Gonçalves on 02/05/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct AnnotationView: View {
    var annotation: AnnotatedItem
    var body: some View {
        ZStack{
            Image(systemName: annotation.image)
                .resizable()
                .aspectRatio(contentMode: .fit)
                .foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                .frame(width: 40, height: 40)
                .cornerRadius(3.0)
            
            Text(annotation.number)
                .fontWeight(.bold)
                .font(.system(size: 13))
                .colorInvert()
                .offset(x: 0, y: -6)
        }
    }
}




struct AnnotationView_Previews: PreviewProvider {
    static var previews: some View {
        HStack{
            Spacer()
            AnnotationView(annotation:
                            AnnotatedItem(number:"",name: "Harold",image: "figure.wave", coordinate: .init(latitude: 40.75773 , longitude: -73.985708)))
            
            
            Spacer()
            AnnotationView(annotation:
                            AnnotatedItem(number:"222",name: "Linha zzz",image: "bus", coordinate: .init(latitude: 40.75773 , longitude: -73.985708)))
            
            Spacer()
            
            AnnotationView(
                annotation: AnnotatedItem(number:"022",
                                          name: "Linha xyz",
                                          image: "bus",
                                          coordinate: .init(latitude: 40.75773 , longitude: -73.985708
                                          )
                )
            )
            
            Spacer()
            
            
        }
       
    }
}

